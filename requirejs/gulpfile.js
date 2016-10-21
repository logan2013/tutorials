/**
 * 
 */
var gulp = require("gulp");
var amdOptimize = require("amd-optimize");
var concat = require('gulp-concat');

var requirejsOptimize = require('gulp-requirejs-optimize');

gulp.task("default", function() {

	return gulp.src("scripts/**/*.js").pipe(amdOptimize("main", {
		paths : {
			jquery : "jquery.v1.8.3"
		}
	})).pipe(concat("index.js")).pipe(gulp.dest("dist/scripts"));

});

gulp.task("gulp-requirejs-optimize", function() {
	
	return gulp.src("scripts/main.js")
		.pipe(requirejsOptimize({
			paths : {
				jquery : "jquery.v1.8.3"
			}
		}))
		.pipe(gulp.dest("dist/scripts2"));
});