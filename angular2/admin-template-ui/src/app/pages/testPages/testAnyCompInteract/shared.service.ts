import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
@Injectable()
export class SharedService {

    memberSubject$: Subject<number> = new Subject<number>();

}