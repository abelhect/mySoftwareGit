import React, {Component} from 'react';
import './app.css'
import Clock from './clock.jsx'
import {Form, FormControl, Button} from 'react-bootstrap';
const image = require('./img/countdown.ico');

class App extends Component {
  constructor(props){
    super(props);
    this.state = {
        deadline : 'December 25, 2017',
        newDeadline: ''
    }
  }

  changeDeadline() {
    this.setState({deadline: this.state.newDeadline})
  }

  render(){
    return(
      <div className='App'>
        <div className="logo-title-block">
          <div className="logo">
            <img src={image} alt="Logo Here" className="logo"/>
          </div>
          <div className='title'>
            CountdownCHAMP
          </div>
        </div>
        <div className='App-title'>Countdown to {this.state.deadline}</div>
        <Clock deadline={this.state.deadline}/>
        <div>
          <Form inline>
            <FormControl
              className='Deadline-input'
              placeholder='new date' onChange={event => this.setState({newDeadline: event.target.value})}
            />
            {/* using es6 anonimous function below to avoid loops that can crash */}
            <Button onClick={() => this.changeDeadline()}>Submit</Button>
          </Form>
        </div>
      </div>

    )
  }
}

export default App;
