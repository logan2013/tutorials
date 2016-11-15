var React = require("react");

module.exports = React.createClass({
    getInitialState: function () {
        console.log("inside todo form of initial");

        return {user: "", task: ""};
    },
    handleUserChange: function (e) {
        this.setState({user: e.target.value});
    },
    handleTaskChange: function (e) {
        this.setState({task: e.target.value});
    },
    handleSubmit: function (e) {
        e.preventDefault();
        this.props.onTodoSubmit({user: this.state.user, task: this.state.task});

        this.setState({user: "", task : ""});
    },

    render: function () {
        return (
            <form className="todoform" onSubmit={this.handleSubmit}>

                <input type="text" placeholder="your name" value={this.state.user} onChange={this.handleUserChange}/>
                <input type="text" placeholder="your task" value={this.state.task} onChange={this.handleTaskChange}/>

                <input type="submit" value="submit"/>

            </form>
        )
    }
});