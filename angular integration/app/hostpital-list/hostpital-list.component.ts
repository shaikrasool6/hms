import { Component, OnInit } from '@angular/core';
import { HospitalService } from '../services/hospital.service';
import { Hospital } from '../models/hospital';

@Component({
  selector: 'app-hostpital-list',
  templateUrl: './hostpital-list.component.html',
  styleUrls: ['./hostpital-list.component.css']
})
export class HostpitalListComponent implements OnInit {

  // hospital: any = { hospId: '', name: '', email: '', phone: '', fax: '' };
  hospital = new Hospital();
  users: any = [];
  constructor(private hospitalService: HospitalService) { }

  ngOnInit() {
    this.getHospital();
  }

  addNew = () => {
    this.hospital = new Hospital();
  }

  getHospital = () => {
    this.hospitalService.getAllHospital().subscribe((response) => {
      this.users = response;
    },
      (error) => {
        console.log(error);
      })
  }

  saveHospital = (hospital) => {
    this.hospitalService.addNewHospital(this.hospital).subscribe((response) => {
      this.getHospital();
    }, (error) => {
      alert(error.error.errors[0]);
    })
  }

  deleteHospital = (hospital) => {
    this.hospitalService.deleteHospital(hospital).subscribe(response => {
      alert(`Hospital with id = ${hospital.hospId} is deleted successfully.`);
      this.getHospital();
    },
      error => {
        alert(`error occures`);
      })
  }

  editHospital = (hospital) => {
    this.hospital = hospital;
  }

}
