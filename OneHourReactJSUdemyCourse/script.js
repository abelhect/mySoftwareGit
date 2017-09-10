//product component that includes state of how many products we are buying
//what product we are buying and renders the view of the HTML divs
var Product = React.createClass({
      getInitialState: function() {
        return {qty: 0};
      },

      buy: function() {
        this.setState({qty: this.state.qty + 1}); //this is just for visual purposes
        this.props.handleTotal(this.props.price);
      },

      show: function() {
        this.props.handleShow(this.props.name);
      },

  render: function() {
    return ( < div >
      < p > {this.props.name} - $ {this.props.price} < /p>
      < button onClick = {this.buy} > Buy < /button>
      < button onClick = {this.show} > Show < /button>
      < h3 > Qty: {this.state.qty} item(s) < /h3>
      <hr/ >
    < /div>);
  }
});

//total component shows the div to display the total of cost for all products bought
var Total = React.createClass({
  render: function() {
    return ( < div >
      < h3 > Total Cash: ${this.props.total}< /h3> < /div >
    );
  }
});

//product form for user to create new product
var ProductForm = React.createClass({
  submit: function(e) {
    e.preventDefault();

    var product={
      name: this.refs.name.value,
      price: parseInt(this.refs.price.value)
    }

    this.props.handleCreate(product);

    this.refs.name.value = "";
    this.refs.price.value = "";
  },

  render: function() {
    return (
      <form  onSubmit={this.submit}>
        <input type="text" placeholder="Product Name" ref="name"/> -
         <input type="text" placeholder="Product Price" ref="price"/>
        <br/><br/>
        <button>Create Product</button>
        <hr/>
      </form>
      );
  }
});


//product list component that renders the list of different products in a div
//also includes a funtion that show what product you selected
var ProductList = React.createClass({
  getInitialState: function(){
    return {
      total: 0,
      productList: [
        {name: "Android", price: 124},
        {name: "Apple", price: 123},
        {name: "Nokia", price: 65}
        ]
    };
  },
  //adding a function to add a new product into the existing array
  createProduct: function(product) {
    this.setState({
      productList: this.state.productList.concat(product)
    })
  },

  calculateTotal: function(price){
    this.setState({total: this.state.total + price});
  },

  showProduct: function(name) {
    alert("You selected " + name);
  },

  render: function() {
    var component = this;
    var products = this.state.productList.map(function(product) {
      return (
        <Product name={product.name} price={product.price}
            handleShow={component.showProduct}
            handleTotal={component.calculateTotal}/>
        );
    });

    return ( < div >
    <ProductForm handleCreate={this.createProduct}/>
       {products} 
      < Total total={this.state.total}/ >
      < /div>
    );

  }
});

//renders the actual list and displays it in the HTML Body with id root
React.render( < ProductList / > , document.getElementById("root"));
