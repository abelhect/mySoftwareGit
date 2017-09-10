class Start extends React.Component{

  start(){
    alert("The Start button was pressed!");
  }

  render(){
    return(
      <div className="start">
        <button id="start-btn" className="btn" onClick={this.componentDidMount}>Start</button>
        {/*need event listener to start the count down*/}
        {/*}<button className="btn">Reset</button>*/}
        {/*need event listener to reset the minutes and the seconds*/}
      </div>
    )
  }
}

class SetTime extends React.Component{
  retrieveTime(){
    alert("The SetTimer button was pressed!");
  }

  render(){
    return(
      <div className="setTime">
        <input id="set_time" type="number" value="5"/>
        <button id="set_time_btn" className="btn" onClick={this.retrieveTime}>Set Timer (min)</button>
      </div>
    )
  }
}

class Picture extends React.Component{
  render(){
    return(
      <div id="picture" className="picture">
        <img src={this.props.img} alt="Photo Here!"/>
        <h1 id="minutes" className="minutes">
        {this.props.timeElapsedMin < 10 ? "0" + this.props.timeElapsedMin : this.props.timeElapsedMin}:{this.props.timeElapsedSec < 10 ? "0" + this.props.timeElapsedSec : this.props.timeElapsedSec}
        </h1>
      </div>
    )
  }
}

class Title extends React.Component{
  render(){
    return(
      <div className="title-div">
        <h1 className="title">POMODORO TIMER</h1>
        <h2 className="subtitle">Set to {this.props.workingTime} minute(s)</h2>
      </div>
    )
  }
}

class PomodoroTimer extends React.Component{

  //constructor is crucial for state.  It fires once everytime the component is called
  constructor(){
    super();
    this.state = {
      timeElapsed: 0,
      timeElapsedMinutes: 0,
      timeElapsedSeconds: 0
    };
  }

  componentDidMount() {
    //*****need to make the start date x minutes in the future to count down
    //start state = current time in milliseconds + workingtime in milliseconds
    this.setState({start: new Date().getTime() + this.props.workingTime * 60000});
    // this.setState({start: new Date()});

    this.interval = setInterval(this.elapseTime.bind(this),1000);
  }

  componentWillUnmount(){
    clearInterval(this.interval);
    // clearTimeout();
  }

  elapseTime() {
    //how much time has elapsed?
    //*****this guys here needs to be the time not the Date
    var currentTime = new Date().getTime();
    // var currentTime = new Date();

    //var timeElapsed = CURRENT TIME - START TIME*/
    //*****need to reverse this formula to be future time - currentTime and get rid of the /1000
    var timeElapsed = Math.round(this.state.start - currentTime);
    // var timeElapsed = Math.round((currentTime - this.state.start)/1000);

    //******formulas for minutes and seconds
    //the minutes is 30 seconds behind so i had to substract 30 secs from timeElapsed for the minutes
    var timeElapsedMinutes = Math.round(((timeElapsed-30000) % (1000 * 60 * 60)) / (1000 * 60));
    var timeElapsedSeconds = Math.round((timeElapsed % (1000 * 60)) / 1000);

    //setting the new state of timeElapsed for printing on DOM
    this.setState({timeElapsed: timeElapsed});
    // *****update the states for the secs and mins
    this.setState({timeElapsedMinutes: timeElapsedMinutes});
    this.setState({timeElapsedSeconds: timeElapsedSeconds});
    // *****changed the workingTime to milliseconds cause timeElapsed is in milliseconds
    if (this.state.timeElapsed <= 0){
    // if (this.state.timeElapsed >= this.props.workingTime*60){
      clearInterval(this.interval);
      this.props.sound.play();
      setTimeout(function(){
        alert("Your time is up.  TAKE A 5 MINUTE BREAK!");
      },1000);
      // this.props.sound.pause();
    }
  }

  totalTime (){
    return this.props.workingTime + this.props.restingTime;
  }


    render (){
      return (
        <div className="pomodoro-timer">
        <Title workingTime= {this.props.workingTime}/>
        <Picture img="images/redDeliciousTomato.jpg" minutes={this.props.workingTime} timeElapsedMin = {this.state.timeElapsedMinutes} timeElapsedSec = {this.state.timeElapsedSeconds}/>
        {/*<SetTime/>
        <Start />*/}
        {/*<div>This timer runs for {this.props.workingTime} minutes,
        followed by rest of {this.props.restingTime} minutes. <br/>
        For total time of {this.totalTime()} minutes. <br/>
        There are {this.state.timeElapsed} seconds elapsed.</div>*/}
        </div>
      )
    }
}

ReactDOM.render(
  <PomodoroTimer workingTime={45} restingTime = {5} sound = {document.getElementById('cuckoo')}/>,
    document.getElementById("app")
);
