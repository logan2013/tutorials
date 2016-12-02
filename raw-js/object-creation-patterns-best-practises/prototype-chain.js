/**
 * Created by Logan on 2016/12/2.
 */
var thingPrototype = {
    f: function () {

    },
    g: function () {

    }
};

function thing() {
    var o = Object.create(thingPrototype);

    o.x = 42;
    o.y = 3.14;

    return o;
}

var o = new thing();