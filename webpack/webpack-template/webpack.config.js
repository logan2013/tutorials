/**
 * Created by Administrator on 2016/12/18.
 */
var path = require("path");

module.exports = {
    entry: path.join(__dirname, "src", "app", "app"),
    output: {
        path: path.join(__dirname, "dist"),
        filename: "bundle.js"
    }
};