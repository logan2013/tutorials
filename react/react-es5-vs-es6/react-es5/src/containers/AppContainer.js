/**
 * Created by Logan on 2017/1/17.
 */
var React = require("react");
var Calculator = require("../components/CalculatorComponent");

var AppContainer = React.createClass({
    getInitialState: function () {
        return {
            value1: 0,
            value2: 0
        };
    },

    render: function () {
        return (
            <Calculator value1={this.state.value1} value2={this.state.value2}/>
        );
    }
});

module.exports = AppContainer;