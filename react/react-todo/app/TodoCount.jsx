var React = require("react");

module.exports = React.createClass({
        render: function () {
            return (
                <div>{this.props.count}</div>
            )
        }
    }
);