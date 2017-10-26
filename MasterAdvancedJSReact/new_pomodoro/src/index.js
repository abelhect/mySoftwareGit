// import './scss/main.scss'; //if you want to use scss instead
var React = require('react');
var ReactDOM = require('react-dom');
import './css/main.css';
var PomodoroTimer = require('./components/pomodoro-timer.jsx');
import m4r from './sounds/cuckoo-cuckoo-clock.m4r';
import './images/pomodoro.ico';

ReactDOM.render(
  <PomodoroTimer workingTime={1} sound={m4r}/>,
    document.getElementById("app")
);
