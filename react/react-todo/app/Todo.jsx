var React = require("react");

var TodoHeader = require("./TodoHeader.jsx");
var TodoForm = require("./TodoForm.jsx");
var TodoList = require("./TodoList.jsx");

module.exports = React.createClass({
    getInitialState: function () {
        return {data: []};
    },

    loadDataFromServer: function () {
        this.setState({
            data: [
                {id: 1, user: "Adam", task: "This is task1"},
                {id: 2, user: "Ricky", task: "This is task2"}
            ]
        });
    },

    componentDidMount: function () {
        this.loadDataFromServer();
    },

    handleTodoSubmit: function (todo) {
        todo.id = Date.now();
        var todos = this.state.data;
        var newTodos = todos.concat([todo]);
        this.setState({data: newTodos});
    },

    render: function () {
        return (
            <div className="todo">

                <TodoHeader count={this.state.data.length}/>
                <TodoForm onTodoSubmit={this.handleTodoSubmit} />
                <TodoList data={this.state.data} />

            </div>
        )
    }
});