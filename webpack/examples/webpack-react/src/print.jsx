import React from "react";

class Print extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: "Inital input value"};
        this.updateValue = this.updateValue.bind(this);
    }
    
    updateValue(event) {
        this.setState({value: event.target.value});
    }
    
    render() {
        return (
            <div>Hello webpack! <input type="text" onChange={this.updateValue} value={this.state.value}></input></div>
        );
    }
}

export default Print;