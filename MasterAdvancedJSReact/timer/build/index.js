class Start extends React.Component {

  start() {
    alert("The Start button was pressed!");
  }

  render() {
    return React.createElement(
      "div",
      { className: "start" },
      React.createElement(
        "button",
        { id: "start-btn", className: "btn", onClick: this.componentDidMount },
        "Start"
      )
    );
  }
}

class SetTime extends React.Component {
  retrieveTime() {
    alert("The SetTimer button was pressed!");
  }

  render() {
    return React.createElement(
      "div",
      { className: "setTime" },
      React.createElement("input", { id: "set_time", type: "number", value: "5" }),
      React.createElement(
        "button",
        { id: "set_time_btn", className: "btn", onClick: this.retrieveTime },
        "Set Timer (min)"
      )
    );
  }
}

class Picture extends React.Component {
  render() {
    return React.createElement(
      "div",
      { id: "picture", className: "picture" },
      React.createElement("img", { src: this.props.img, alt: "Photo Here!" }),
      React.createElement(
        "h1",
        { id: "minutes", className: "minutes" },
        this.props.timeElapsedMin < 10 ? "0" + this.props.timeElapsedMin : this.props.timeElapsedMin,
        ":",
        this.props.timeElapsedSec < 10 ? "0" + this.props.timeElapsedSec : this.props.timeElapsedSec
      )
    );
  }
}

class Title extends React.Component {
  render() {
    return React.createElement(
      "div",
      { className: "title-div" },
      React.createElement(
        "h1",
        { className: "title" },
        "POMODORO TIMER"
      ),
      React.createElement(
        "h2",
        { className: "subtitle" },
        "Set to ",
        this.props.workingTime,
        " minute(s)"
      )
    );
  }
}

class PomodoroTimer extends React.Component {

  //constructor is crucial for state.  It fires once everytime the component is called
  constructor() {
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
    this.setState({ start: new Date().getTime() + this.props.workingTime * 60000 });
    // this.setState({start: new Date()});

    this.interval = setInterval(this.elapseTime.bind(this), 1000);
  }

  componentWillUnmount() {
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
    var timeElapsedMinutes = Math.round((timeElapsed - 30000) % (1000 * 60 * 60) / (1000 * 60));
    var timeElapsedSeconds = Math.round(timeElapsed % (1000 * 60) / 1000);

    //setting the new state of timeElapsed for printing on DOM
    this.setState({ timeElapsed: timeElapsed });
    // *****update the states for the secs and mins
    this.setState({ timeElapsedMinutes: timeElapsedMinutes });
    this.setState({ timeElapsedSeconds: timeElapsedSeconds });
    // *****changed the workingTime to milliseconds cause timeElapsed is in milliseconds
    if (this.state.timeElapsed <= 0) {
      // if (this.state.timeElapsed >= this.props.workingTime*60){
      clearInterval(this.interval);
      this.props.sound.play();
      setTimeout(function () {
        alert("Your time is up.  TAKE A 5 MINUTE BREAK!");
      }, 1000);
      // this.props.sound.pause();
    }
  }

  totalTime() {
    return this.props.workingTime + this.props.restingTime;
  }

  render() {
    return React.createElement(
      "div",
      { className: "pomodoro-timer" },
      React.createElement(Title, { workingTime: this.props.workingTime }),
      React.createElement(Picture, { img: "images/redDeliciousTomato.jpg", minutes: this.props.workingTime, timeElapsedMin: this.state.timeElapsedMinutes, timeElapsedSec: this.state.timeElapsedSeconds })
    );
  }
}

ReactDOM.render(React.createElement(PomodoroTimer, { workingTime: 45, restingTime: 5, sound: document.getElementById('cuckoo') }), document.getElementById("app"));