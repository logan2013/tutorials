import {Injectable} from "@angular/core";
/**
 * Created by Administrator on 2016/12/7.
 */
@Injectable()
export class GreeterService {
  age: number = 30;

  getAge() {
    return this.age;
  }
}
