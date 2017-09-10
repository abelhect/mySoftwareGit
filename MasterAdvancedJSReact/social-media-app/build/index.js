var person = {
  name: 'Hector Martinez',
  location: 'Tampa, FL',
  occupation: {
    title: 'Saving the world',
    employer: '@CBORGTECH LLC'
  },
  photo: 'images/superPapo.png',
  updates: [{
    platform: 'twitter',
    status: 'I\'m happy, hope you\'re too!'
  }, {
    platform: 'twitter',
    status: 'Fear makes the wolf look bigger!'
  }, {
    platform: 'facebook',
    status: 'If you break it, you buy it!'
  }]
};

class Updates extends React.Component {

  updates() {

    return this.props.updates.map(function (update, index) {
      return React.createElement(
        'li',
        { className: "update " + update.platform, key: index },
        update.status
      );
    });
  }

  render() {
    return React.createElement(
      'div',
      { className: 'updates' },
      React.createElement(
        'ul',
        null,
        this.updates()
      )
    );
  }
}

class Bio extends React.Component {
  render() {
    return React.createElement(
      'div',
      { className: 'bio' },
      React.createElement(
        'h1',
        { className: 'name' },
        this.props.name
      ),
      React.createElement(
        'h2',
        { className: 'location' },
        this.props.location
      ),
      React.createElement(
        'div',
        { className: 'occupation' },
        React.createElement(
          'p',
          null,
          this.props.occupation
        )
      )
    );
  }
}

class Photo extends React.Component {
  render() {
    return React.createElement(
      'div',
      { className: 'photo' },
      React.createElement('img', { src: this.props.photo, alt: 'Photo' })
    );
  }
}

class Card extends React.Component {
  render() {

    return React.createElement(
      'div',
      { className: 'card' },
      React.createElement(Photo, { photo: person.photo }),
      React.createElement(Bio, { name: person.name, location: person.location,
        occupation: person.occupation.title + " " + person.occupation.employer }),
      React.createElement(Updates, { updates: person.updates })
    );
  }
}

ReactDOM.render(React.createElement(Card, null), document.getElementById('app'));