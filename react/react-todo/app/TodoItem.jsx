import React  from  "react";

export default React.createClass({
        render: function () {
            return (
                <li> {this.props.user} - {this.props.task}</li>
            )
        }
    }
);