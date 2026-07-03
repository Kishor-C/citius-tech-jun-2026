import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'idGen',
  standalone: false,
})
export class IdGenPipe implements PipeTransform {
  // ... is varying arguments
  transform(value: number, args: string): string {
    return args.slice(0, 2) + value;
  }
}
