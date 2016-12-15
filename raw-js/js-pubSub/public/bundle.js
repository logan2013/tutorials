/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "D:\\important_github\\logan\\tutorials\\raw-js\\js-pubSub\\public";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	"use strict";

	/**
	 * Created by Logan on 2016/12/15.
	 */

	var EventManager = __webpack_require__(1);

	EventManager.subscribe("ADD_USER", function (user) {
	    console.log(user);
	});

	var submit = document.getElementById("submit");

	submit.onclick = function (e) {
	    e.preventDefault();

	    var user = { firstName: "hello", lastName: "world" };

	    EventManager.publish("ADD_USER", user);

	    console.log("finishing......");
	};

/***/ },
/* 1 */
/***/ function(module, exports) {

	"use strict";

	/**
	 * Created by Logan on 2016/12/15.
	 */
	var EventManager = new function () {

	    var events = {};

	    this.publish = function (name, data) {
	        return new Promise(function (resolve, reject) {
	            var handlers = events[name];
	            if (!!handlers === false) {
	                return;
	            }

	            handlers.forEach(function (handler) {
	                handler.call(this, data);
	            });
	            resolve();
	        });
	    };

	    this.subscribe = function (name, handler) {
	        var handlers = events[name];
	        if (!!handlers === false) {
	            handlers = events[name] = [];
	        }

	        handlers.push(handler);
	    };

	    this.unsubscribe = function (name, handler) {

	        var handlers = events[name];

	        if (!!handlers === false) {
	            return;
	        }

	        var handlerIdx = handlers.indexOf(handler);
	        handlers.splice(handlerIdx);
	    };
	}();

	module.exports = EventManager;

/***/ }
/******/ ]);