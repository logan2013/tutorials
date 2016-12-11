/**
 * Created by Logan on 2016/12/2.
 */

(function () {
    class Employee {
        constructor(firstName, familyName) {
            this._firstName = firstName;
            this._familyName = familyName;
        }

        getFullName() {
            return `${this._firstName} ${this._familyName}`;
        }
    }

    /**
     * 不使用extends
     */
    class Manager {
        constructor(firstName, familyName) {
            this._firstName = firstName;
            this._familyName = familyName;

            this._managedEmployees = [];
        }

        getFullName() {
            return `${this._firstName} ${this._familyName}`;
        }

        addEmployee(employee) {
            this._managedEmployees.push(employee);
        }
    }

    /**
     * 使用extends
     */
    class Manager2 extends Employee {
        constructor(firstName, familyName) {
            super(firstName, familyName);

            this._managedEmployees = [];
        }

        addEmployee(employee) {
            this._managedEmployees.push(employee);
        }
    }
})();