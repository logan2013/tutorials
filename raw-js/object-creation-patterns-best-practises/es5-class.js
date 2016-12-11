/**
 * Created by Logan on 2016/12/2.
 */
function create(fn) {
    var o = Object.create(fn.prototype);

    fn.call(o);

    return o;
}

Thing.prototype.f = function () {

};

Thing.prototype.g = function () {

};

function Thing() {
    this.x = 42;
    this.y = 3.14;
}

var o = create(Thing);