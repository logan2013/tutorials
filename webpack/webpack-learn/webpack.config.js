var path = require('path');

module.exports = {
    entry: {
        'bundle': './app/index'    
    },
    output: {
        path: path.join(__dirname, 'build'),
        filename: "[name].js"   
    },
    module: {
        loaders: [
            {
                test: /.js$/,
                include : path.join(__dirname, "app"),
                loader: 'babel',
                query: {
                    cacheDirectory : !(process.env.NODE_ENV === 'prod'),
                    presets: [
                        'es2015'
                    ]    
                }    
            }        
        ]    
    },
    devServer: {
        /*
        * 配置web服务的根目录
        */
        contentBase: path.join(__dirname, 'build')
    }
};