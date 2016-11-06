import React from "react";
import ReactDOM from "react-dom";

import Print from "./print.jsx";

import "./css/style.css";

class Index extends React.Component {
    render() {
        
        return (
            <div>
                <Print/>
            </div>
        );
    }
}

ReactDOM.render(<Index/>, document.getElementsByClassName("application")[0]);