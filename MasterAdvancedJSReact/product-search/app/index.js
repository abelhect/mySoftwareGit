//when pulling the library into your project you need to require these mofos below
var React = require('react');
var ReactDOM = require('react-dom');
var Search = require('./components/search.jsx')
var products = require('./products.js');  //jason array of products (like an API or database)
import './img/product-search.ico';

ReactDOM.render(
  <Search products={products}/>,
  document.getElementById("app")
);
