import { Pipe, PipeTransform } from '@angular/core';
import { Hospital } from '../models/hospital';
@Pipe({
    name: 'filter'
})
export class SearchPipe implements PipeTransform {
    transform(items: Hospital[], searchText: string): Hospital[] {
        if (!items) return [];
        if (!searchText) return items;
        searchText = searchText.toLowerCase();
        return items.filter(it => {
            return it.email.toLowerCase().includes(searchText)||it.name.toLowerCase().includes(searchText);
        });
    }
}