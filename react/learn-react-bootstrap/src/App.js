import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {Button, ButtonGroup, DropdownButton, MenuItem} from "react-bootstrap";

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/css/bootstrap-theme.css";

class App extends Component {
  render() {
    return (
      <ButtonGroup>
          <DropdownButton id="dropdown-btn-menu" bsStyle="success" title="Dropdown">
              <MenuItem key="1">Dropdown link</MenuItem>
              <MenuItem key="2">Dropdown link</MenuItem>
          </DropdownButton>

          <Button bsStyle="info">Middle</Button>
          <Button bsStyle="info">Right</Button>
      </ButtonGroup>
    );
  }
}

export default App;
