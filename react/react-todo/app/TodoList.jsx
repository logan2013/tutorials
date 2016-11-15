var React = require("react");
var TodoItem = require("./TodoItem.jsx");

module.exports = React.createClass({
    render: function () {
        var todoTasks = this.props.data.map(function (todoItem) {
            return (
                <TodoItem user={todoItem.user} task={todoItem.task} key={todoItem.id}/>
            )
        });

        return (
            <div className="todo list">

                <ul> Todo List {todoTasks}</ul>

            </div>
        )
    }
});