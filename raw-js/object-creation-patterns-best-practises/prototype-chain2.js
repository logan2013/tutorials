/**
 * Created by Logan on 2016/12/2.
 */
thing.prototype.f = function () {

};

thing.prototype.g = function () {

}

function thing() {
    var o = Object.create(thing.prototype);

    o.x = 42;
    o.y = 3.14;

    return o;
}

var o = thing();