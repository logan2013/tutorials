import React  from  "react";
import TodoItem  from "./TodoItem.jsx";

export default React.createClass({
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