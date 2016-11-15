var React = require("react");
var TodoCount = require("./TodoCount.jsx")

module.exports = React.createClass({
        render: function () {
            return (
                <nav>Header <TodoCount count={this.props.count} /></nav>
            )
        }
    }
);