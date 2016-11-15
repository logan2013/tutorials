import React  from  "react";

class TodoCount extends React.Component {
    render() {
        return (
            <div>{this.props.count}</div>
        )
    }
}

export default TodoCount;