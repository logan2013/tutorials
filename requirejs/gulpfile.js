/**
 * 
 */
var gulp = require("gulp");
var amdOptimize = require("amd-optimize");
var concat = require('gulp-concat');

gulp.task("scripts:index", function () {

  return gulp.src("scripts/**/*.js")
    .pipe(amdOptimize("main"))
    .pipe(concat("index.js"))
    .pipe(gulp.dest("dist/scripts"));

});