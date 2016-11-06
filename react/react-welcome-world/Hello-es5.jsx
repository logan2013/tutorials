var React = require("react");

var Hello = React.createClass({

    displayName: "Hello",
    
    render: function() {
        return React.createElement("h1", null, "Hello");
    }
});