/**
 * Created by Administrator on 2016/12/18.
 */
var path = require("path");

module.exports = {
    context: path.join(__dirname, "src"),
    entry: {
        app: "./app/app",
        about: "./about/about"
    },
    output: {
        path: path.join(__dirname, "dist"),
        filename: "[name].bundle.js"
    },
    module: {
        loaders: [{
            test: /\.js$/,
            loader: "babel",
            include: path.join(__dirname, "src")

        }]
    }
};