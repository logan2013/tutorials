import React  from  "react";
import TodoCount from "./TodoCount.jsx";

export  default React.createClass({
        render: function () {
            return (
                <nav>Header <TodoCount count={this.props.count}/></nav>
            )
        }
    }
);