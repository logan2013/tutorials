import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertToEuro'
})
export class ConvertToEuroPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return null;
  }

}
