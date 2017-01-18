/**
 * Created by Logan on 2017/1/17.
 */
var React = require("react");

var Calculator = React.createClass({

    getInitialState: function () {
        return ({
            value1: this.props.value1,
            value2: this.props.value2,
            result: 0
        });
    },

    handleChangeValue1: function (e) {
        this.setState({value1: e.target.value});
    },

    handleChangeValue2: function (e) {
        this.setState({value2: e.target.value});
    },

    calculate: function (e) {
        e.preventDefault();

        this.setState({
            result: Number.parseInt(this.state.value1) + Number.parseInt(this.state.value2)
        })
    },

    render: function () {
        return (
            <form>
                <div>
                    <label>Value 1</label>
                    <input name="value1" type="text" onChange={this.handleChangeValue1} value={this.state.value1}/>
                </div>

                <div>
                    <label>Value 2</label>
                    <input name="value2" type="text" onChange={this.handleChangeValue2} value={this.state.value2}/>
                </div>

                <div>
                    <label>Result</label>
                    <div id="result">{this.state.result}</div>
                </div>

                <div>
                    <button onClick={this.calculate}>Calculate</button>
                </div>
            </form>
        );
    }
});

module.exports = Calculator;