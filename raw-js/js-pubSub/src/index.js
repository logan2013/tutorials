/**
 * Created by Logan on 2016/12/15.
 */

var EventManager = require("./EventManager");

EventManager.subscribe("ADD_USER", function (user) {
    console.log(user);
});

var submit = document.getElementById("submit");

submit.onclick = function (e) {
    e.preventDefault();

    var user = {firstName: "hello", lastName: "world"};

    EventManager.publish("ADD_USER", user);

    console.log("finishing......");
};