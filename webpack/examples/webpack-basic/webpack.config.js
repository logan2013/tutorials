"use strict";

module.exports = {
    entry: ["./src/index.js"],
    output: {
        filename: "./dist/bundle.js"    
    },
    module: {
        loaders: [
            {
                test: /\.css$/,
                loaders: ["style", "css"]    
            }
        ]    
    }    
};