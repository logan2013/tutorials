import {OnInit, Component} from '@angular/core';
import {FormGroup, FormBuilder, Validators, ValidatorFn, AbstractControl} from '@angular/forms';
import {Http} from '@angular/http';

/**
 * 20-40
 * @param c
 * @returns {any}
 *
 * return null
 * return {}
 *
 */
function ageValidator(ageControl: AbstractControl): {[key: string]: boolean} | null {

    if (ageControl.pristine) {
        return null;
    }
    return { 'ageMatch': true };
}

@Component({
    selector: 'test-form',
    templateUrl: './testForm.html'
})
export class TestFormComponent implements OnInit {

    memberForm: FormGroup;

    constructor(private fb: FormBuilder,private http: Http) {
    }

    ngOnInit(): void {
        this.memberForm = this.fb.group({
            'memberName':[{value: 'zhangsan', disabled: false}, [Validators.required, Validators.minLength(6)]],
            'password': [''],
            'age': '',
            'sex': ['male'],
            'interests': this.fb.group(
                {
                    interests1: '',
                    interests2: '',
                    interests3: ''
                }
            )
        });
    }

    onSubmit() {
        // this.http.post('/submitForm', this.memberForm.value);
    }
}