<?php include('includes/header.php'); ?>

        <div class="container">
            <ul class="breadcrumb">
                <li>
                    <a href="index.html">Home</a>
                </li>
                <li>
                    <a href="#">United States</a>
                </li>
                <li>
                    <a href="#">New York (NY)</a>
                </li>
                <li>
                    <a href="#">New York City</a>
                </li>
                <li class="active">New York City Flights</li>
            </ul>
            <div class="mfp-with-anim mfp-hide mfp-dialog mfp-search-dialog" id="search-dialog">
                <h3>Search for Flight</h3>
                <form>
                    <div class="tabbable">
                        <ul class="nav nav-pills nav-sm nav-no-br mb10" id="flightChooseTab">
                            <li class="active">
                                <a href="#flight-search-1" data-toggle="tab">Round Trip</a>
                            </li>
                            <li>
                                <a href="#flight-search-2" data-toggle="tab">One Way</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="flight-search-1">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group form-group-lg form-group-icon-left">
                                            <i class="fa fa-map-marker input-icon input-icon-highlight"></i>
                                            <label>From</label>
                                            <input class="typeahead form-control" placeholder="City, Airport or U.S. Zip Code" type="text" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group form-group-lg form-group-icon-left">
                                            <i class="fa fa-map-marker input-icon input-icon-highlight"></i>
                                            <label>To</label>
                                            <input class="typeahead form-control" placeholder="City, Airport or U.S. Zip Code" type="text" />
                                        </div>
                                    </div>
                                </div>
                                <div class="input-daterange" data-date-format="MM d, D">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group form-group-lg form-group-icon-left">
                                                <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                <label>Departing</label>
                                                <input class="form-control" name="start" type="text" />
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group form-group-lg form-group-icon-left">
                                                <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                <label>Returning</label>
                                                <input class="form-control" name="end" type="text" />
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group form-group-lg form-group-select-plus">
                                                <label>Passengers</label>
                                                <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                    <label class="btn btn-primary active">
                                                        <input type="radio" name="options" />1</label>
                                                    <label class="btn btn-primary">
                                                        <input type="radio" name="options" />2</label>
                                                    <label class="btn btn-primary">
                                                        <input type="radio" name="options" />3</label>
                                                    <label class="btn btn-primary">
                                                        <input type="radio" name="options" />4</label>
                                                    <label class="btn btn-primary">
                                                        <input type="radio" name="options" />5</label>
                                                    <label class="btn btn-primary">
                                                        <input type="radio" name="options" />5+</label>
                                                </div>
                                                <select class="form-control hidden">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                    <option selected="selected">6</option>
                                                    <option>7</option>
                                                    <option>8</option>
                                                    <option>9</option>
                                                    <option>10</option>
                                                    <option>11</option>
                                                    <option>12</option>
                                                    <option>13</option>
                                                    <option>14</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="flight-search-2">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group form-group-lg form-group-icon-left">
                                            <i class="fa fa-map-marker input-icon input-icon-highlight"></i>
                                            <label>From</label>
                                            <input class="typeahead form-control" placeholder="City, Airport or U.S. Zip Code" type="text" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group form-group-lg form-group-icon-left">
                                            <i class="fa fa-map-marker input-icon input-icon-highlight"></i>
                                            <label>To</label>
                                            <input class="typeahead form-control" placeholder="City, Airport or U.S. Zip Code" type="text" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group form-group-lg form-group-icon-left">
                                            <i class="fa fa-calendar input-icon input-icon-hightlight"></i>
                                            <label>Departing</label>
                                            <input class="date-pick form-control" data-date-format="MM d, D" type="text" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group form-group-lg form-group-select-plus">
                                            <label>Passengers</label>
                                            <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                <label class="btn btn-primary active">
                                                    <input type="radio" name="options" />1</label>
                                                <label class="btn btn-primary">
                                                    <input type="radio" name="options" />2</label>
                                                <label class="btn btn-primary">
                                                    <input type="radio" name="options" />3</label>
                                                <label class="btn btn-primary">
                                                    <input type="radio" name="options" />4</label>
                                                <label class="btn btn-primary">
                                                    <input type="radio" name="options" />5</label>
                                                <label class="btn btn-primary">
                                                    <input type="radio" name="options" />5+</label>
                                            </div>
                                            <select class="form-control hidden">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                                <option selected="selected">6</option>
                                                <option>7</option>
                                                <option>8</option>
                                                <option>9</option>
                                                <option>10</option>
                                                <option>11</option>
                                                <option>12</option>
                                                <option>13</option>
                                                <option>14</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-primary btn-lg" type="submit">Search for Flights</button>
                </form>
            </div>
            <h3 class="booking-title">12 Flights from London to New York on Mar 22 for 1 adult
                <small>
                    <a class="popup-text" href="#search-dialog" data-effect="mfp-zoom-out">Change search</a>
                </small>
            </h3>
            <div class="row">
                <div class="col-md-3">
                    <aside class="booking-filters text-white">
                        <h4>Filter By:</h4>
                        <ul class="list booking-filters-list">
                            <li>
                                <h5 class="booking-filters-title">Stops
                                    <small>Price from</small>
                                </h5>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Non-stop
                                        <span class="pull-right">NGN 300,000</span>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />1 Stop
                                        <span class="pull-right">NGN 280,000</span>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />2+ Stops
                                        <span class="pull-right">NGN 160,000</span>
                                    </label>
                                </div>
                            </li>
                            <li>
                                <h5 class="booking-filters-title">Price </h5>
                                <input type="text" id="price-slider">
                            </li>
                            <li>
                                <h5 class="booking-filters-title">Flight Class
                                    <small>Price from</small>
                                </h5>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Economy
                                        <span class="pull-right">NGN 300k</span>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Business
                                        <span class="pull-right">NGN 500k</span>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />First
                                        <span class="pull-right">NGN 800k</span>
                                    </label>
                                </div>
                            </li>
                            <li>
                                <h5 class="booking-filters-title">Airlines
                                    <small>Price from</small>
                                </h5>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Lufthansa
                                        <span class="pull-right">NGN 300,000</span>
                                    </label>
                                </div>

                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Airfrance
                                        <span class="pull-right">NGN 300,000</span>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Croatia Airlines
                                        <span class="pull-right">NGN 300,000</span>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Delta
                                        <span class="pull-right">NGN 300,000</span>
                                    </label>
                                </div>

                            </li>
                            <li>
                                <h5 class="booking-filters-title">Departure Time</h5>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Morning (5:00a - 11:59a)</label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Afternoon (12:00p - 5:59p)</label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input class="i-check" type="checkbox" />Evening (6:00p - 11:59p)</label>
                                </div>
                            </li>
                        </ul>
                    </aside>
                </div>
                <div class="col-md-9">
                    <div class="nav-drop booking-sort">
                        <h5 class="booking-sort-title">
                            <a href="#">Sort: Sort: Price (low to high)
                                <i class="fa fa-angle-down"></i>
                                <i class="fa fa-angle-up"></i>
                            </a>
                        </h5>
                        <ul class="nav-drop-menu">
                            <li>
                                <a href="#">Price (high to low)</a>
                            </li>
                            <li>
                                <a href="#">Duration</a>
                            </li>
                            <li>
                                <a href="#">Stops</a>
                            </li>
                            <li>
                                <a href="#">Arrival</a>
                            </li>
                            <li>
                                <a href="#">Departure</a>
                            </li>
                        </ul>
                    </div>
                    <ul class="booking-list">

                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/delta.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>Delta</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 300,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/airfrance.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>Air France</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 355,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/american-airlines.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>American Airlines</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 345,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/aircanada.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>Air Canada</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 412,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/lufthansa.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>Lufthansa</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 412,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/delta.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>Delta</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 300,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/airfrance.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>Air France</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 355,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/american-airlines.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>American Airlines</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 345,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/aircanada.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>Air Canada</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 412,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="booking-item-container">
                                <div class="booking-item">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="booking-item-airline-logo">
                                                <img src="img/lufthansa.jpg" alt="Image Alternative text" title="Image Title" />
                                                <p>Lufthansa</p>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="booking-item-flight-details">
                                                <div class="booking-item-departure">
                                                    <i class="fa fa-plane"></i>
                                                    <h5>10:25 PM</h5>
                                                    <p class="booking-item-date">Sun, Mar 22</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                                <div class="booking-item-arrival">
                                                    <i class="fa fa-plane fa-flip-vertical"></i>
                                                    <h5>12:25 PM</h5>
                                                    <p class="booking-item-date">Sat, Mar 23</p>
                                                    <p class="booking-item-destination">London, United Kingdom (LHR)</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 stop-duration text-right">
                                            <h5>22h 50m</h5>
                                            <p>2 stops</p>
                                        </div>

                                        <div class="col-md-3 text-right">
                                            <span class="booking-item-price">NGN 412,000</span>

                                            <p class="booking-item-flight-class"> Economy, Round Trip
                                                <span class="booking-item-people">/person</span>
                                            </p>
                                            <a class="btn btn-primary" href="#">Select</a>
                                        </div>
                                        <div class="col-md-1">
                                            <i class="fa fa-chevron-down"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="booking-item-details">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h5 class="list-title">Murtala Muhammed International Airport (LOS) - Lomé–Tokoin International Airport
                                                (LFW)
                                            </h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <h5 class="flights__stopover">7h 1m stopover
                                                <span class="flights__separator"></span> Charlotte (CLT) </h5>
                                            <h5 class="list-title">Charlotte (CLT) to New York (JFK)</h5>
                                            <ul class="list">
                                                <li class="text-brown flights__timing">09:55 AM - 3:10 PM
                                                    <span class="flights__separator">
                                                        <span class="text-color"> Duration: 1h 42m</span>
                                                </li>
                                                <li class="text-semi-nude f12">Economy
                                                    <span class="flights__separator"></span> US Airways 731
                                                    <span class="flights__separator"></span> Coach Class (M), AIRBUS INDUSTRIE A330-300 </li>
                                            </ul>
                                            <p class="flights__duration">Total trip time: 17h 58m</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>






                    </ul>
                    <p class="text-right">Not what you're looking for?
                        <a class="popup-text" href="#search-dialog" data-effect="mfp-zoom-out">Try your search again</a>
                    </p>
                </div>
            </div>
            <div class="gap"></div>
        </div>



        <?php include('includes/footer.php'); ?>