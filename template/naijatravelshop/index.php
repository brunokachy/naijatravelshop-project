<?php include('includes/header.php'); ?>

        <!-- TOP AREA -->
        <div class="top-area show-onload auto-height">
            <div class="bg-holder full">
                <div class="bg-front full-height bg-front-mob-rel">
                    <div class="container full-height">
                        <div class="rel full-height">
                            <div class="tagline visible-lg" id="tagline">
                                <span>Search your top</span>
                                <ul>
                                    <li>flight deals</li>
                                    <li>hotel deals</li>

                                    <li class="active">discover</li>
                                </ul>
                            </div>
                            <div class="search-tabs search-tabs-bg search-tabs-bottom mb50">
                                <div class="tabbable">
                                    <ul class="nav nav-tabs" id="myTab">
                                        <li class="active">
                                            <a href="#tab-2" data-toggle="tab">
                                                <i class="fa fa-plane"></i>
                                                <span>Flights</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#tab-1" data-toggle="tab">
                                                <i class="fa fa-building-o"></i>
                                                <span>Hotels</span>
                                            </a>
                                        </li>


                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane fade in active" id="tab-2">
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
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="form-control" name="start" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Returning</label>
                                                                                    <input class="form-control" name="end" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
                                                                                        <option>6</option>
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
                                                        </div>
                                                        <div class="tab-pane fade" id="flight-search-2">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="date-pick form-control" data-date-format="M d, D" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
                                                                                        <option>6</option>
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
                                                        </div>
                                                    </div>
                                                    <div class="tab-content additional-tabs">
                                                        <div class="tab-pane fade in active" id="flight-search-1">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="form-control" name="start" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Returning</label>
                                                                                    <input class="form-control" name="end" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
                                                                                        <option>6</option>
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
                                                        </div>
                                                        <div class="tab-pane fade" id="flight-search-2">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="date-pick form-control" data-date-format="M d, D" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
                                                                                        <option>6</option>
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
                                                        </div>
                                                    </div>
                                                    <div class="tab-content additional-tabs">
                                                        <div class="tab-pane fade in active" id="flight-search-1">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="form-control" name="start" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Returning</label>
                                                                                    <input class="form-control" name="end" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
                                                                                        <option>6</option>
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
                                                        </div>
                                                        <div class="tab-pane fade" id="flight-search-2">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="date-pick form-control" data-date-format="M d, D" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
                                                                                        <option>6</option>
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
                                                        </div>
                                                    </div>
                                                    <div class="tab-content additional-tabs">
                                                        <div class="tab-pane fade in active" id="flight-search-1">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="form-control" name="start" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Returning</label>
                                                                                    <input class="form-control" name="end" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
                                                                                        <option>6</option>
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
                                                        </div>
                                                        <div class="tab-pane fade" id="flight-search-2">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                                <i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left">
                                                                                    <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="date-pick form-control" data-date-format="M d, D" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
                                                                                        <option>6</option>
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
                                                        </div>
                                                    </div>
                                                </div>
                                                <a href="flights.html"><button class="btn btn-primary btn-lg" type="submit">Search for Flights</button></a>
                                            </form>
                                        </div>
                                        <div class="tab-pane fade " id="tab-1">
                                            <form>
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group form-group-lg form-group-icon-left">
                                                            <i class="fa fa-map-marker input-icon"></i>
                                                            <label>Where are you going?</label>
                                                            <input class="typeahead form-control" placeholder="City, Airport, Point of Interest or U.S. Zip Code" type="text" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="input-daterange" data-date-format="M d, D">
                                                            <div class="row">
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-icon-left">
                                                                        <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>Check-in</label>
                                                                        <input class="form-control" name="start" type="text" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-icon-left">
                                                                        <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>Check-out</label>
                                                                        <input class="form-control" name="end" type="text" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-select-plus">
                                                                        <label>Rooms</label>
                                                                        <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                            <label class="btn btn-primary active">
                                                                                <input type="radio" name="options" />1</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />2</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3+</label>
                                                                        </div>
                                                                        <select class="form-control hidden">
                                                                            <option>1</option>
                                                                            <option>2</option>
                                                                            <option>3</option>
                                                                            <option selected="selected">4</option>
                                                                            <option>5</option>
                                                                            <option>6</option>
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
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-select-plus">
                                                                        <label>Guests</label>
                                                                        <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                            <label class="btn btn-primary active">
                                                                                <input type="radio" name="options" />1</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />2</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3+</label>
                                                                        </div>
                                                                        <select class="form-control hidden">
                                                                            <option>1</option>
                                                                            <option>2</option>
                                                                            <option>3</option>
                                                                            <option selected="selected">4</option>
                                                                            <option>5</option>
                                                                            <option>6</option>
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
                                                <button class="btn btn-primary btn-lg" type="submit">Search for Hotels</button>
                                            </form>
                                        </div>


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="owl-carousel owl-slider owl-carousel-area visible-lg" id="owl-carousel-slider" data-nav="false">
                    <div class="bg-holder full">
                        <div class="bg-mask"></div>
                        <div class="bg-img" style="background-image:url(img/hero-banc.png);"></div>
                    </div>
                    <div class="bg-holder full">
                        <div class="bg-mask"></div>
                        <div class="bg-img" style="background-image:url(img/hero-banc.png);"></div>
                    </div>
                    <div class="bg-holder full">
                        <div class="bg-mask"></div>
                        <div class="bg-img" style="background-image:url(img/hero-banc.png);"></div>
                    </div>
                </div>

                <div class="bg-mask hidden-lg"></div>
            </div>
        </div>
        <!-- END TOP AREA  -->




        <div class="container-fluid bg-light-grey">
            <div class="container">
                <div class="gap"></div>
                <h2 class="text-left mb20">Last Minute Deals</h1>
                    <div class="row row-wrap">
                        <div class="col-md-3">
                            <div class="thumb last-minute-card">
                                <header class="thumb-header">
                                    <a class="hover-img" href="#">
                                        <img src="img/waldorf-astoria.png" alt="Waldorf Astoria New York" title="Waldorf Astoria New York" />
                                        <h5 class="hover-title-center">Book Now</h5>
                                    </a>
                                </header>
                                <div class="last-minute-caption">
                                    <ul class="icon-group text-tiny text-color">
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star-half-empty"></i>
                                        </li>
                                    </ul>
                                    <h5 class="thumb-title">
                                        <a class="text-darken" href="#">Waldorf Astoria New York</a>
                                    </h5>
                                    <p class="mb0">
                                        <small>
                                            <i class="fa fa-map-marker"></i> Flushing, NY (LaGuardia Airport (LGA))</small>
                                    </p>
                                    <p class="mb0 text-darken">
                                        <span class="text-lg lh1em text-color">NGN 30,000</span>
                                        <small> per night</small>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="thumb last-minute-card">
                                <header class="thumb-header">
                                    <a class="hover-img" href="#">
                                        <img src="img/waldorf-astoria.png" alt="Image Alternative text" title="hotel PORTO BAY RIO INTERNACIONAL de luxe" />
                                        <h5 class="hover-title-center">Book Now</h5>
                                    </a>
                                </header>
                                <div class="last-minute-caption">
                                    <ul class="icon-group text-tiny text-color">
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                    </ul>
                                    <h5 class="thumb-title">
                                        <a class="text-darken" href="#">The London NYC</a>
                                    </h5>
                                    <p class="mb0">
                                        <small>
                                            <i class="fa fa-map-marker"></i> New York, NY (Chelsea)</small>
                                    </p>
                                    <p class="mb0 text-darken">
                                        <span class="text-lg lh1em text-color">NGN 17,000</span>
                                        <small> / per night</small>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="thumb last-minute-card">
                                <header class="thumb-header">
                                    <a class="hover-img" href="#">
                                        <img src="img/waldorf-astoria.png" alt="Image Alternative text" title="hotel 1" />
                                        <h5 class="hover-title-center">Book Now</h5>
                                    </a>
                                </header>
                                <div class="last-minute-caption">
                                    <ul class="icon-group text-tiny text-color">
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star-half-empty"></i>
                                        </li>
                                    </ul>
                                    <h5 class="thumb-title">
                                        <a class="text-darken" href="#">Grand Hyatt New York</a>
                                    </h5>
                                    <p class="mb0">
                                        <small>
                                            <i class="fa fa-map-marker"></i> Ozone Park, NY (Kennedy Airport (JFK))</small>
                                    </p>
                                    <p class="mb0 text-darken">
                                        <span class="text-lg lh1em text-color">NGN 26,000</span>
                                        <small> /per night</small>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="thumb last-minute-card">
                                <header class="thumb-header">
                                    <a class="hover-img" href="#">
                                        <img src="img/waldorf-astoria.png" alt="Waldorf Astoria New York" title="Waldorf Astoria New York" />
                                        <h5 class="hover-title-center">Book Now</h5>
                                    </a>
                                </header>
                                <div class="last-minute-caption">
                                    <ul class="icon-group text-tiny text-color">
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star"></i>
                                        </li>
                                        <li>
                                            <i class="fa fa-star-o"></i>
                                        </li>
                                    </ul>
                                    <h5 class="thumb-title">
                                        <a class="text-darken" href="#">Affinia Shelburne</a>
                                    </h5>
                                    <p class="mb0">
                                        <small>
                                            <i class="fa fa-map-marker"></i> Brooklyn, NY (Brooklyn)</small>
                                    </p>
                                    <p class="mb0 text-darken">
                                        <span class="text-lg lh1em text-color">NGN 43,000</span>
                                        <small> / per night</small>
                                    </p>
                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="gap gap-small"></div>
            </div>
        </div>

        <div class="container-fluid bg-flight-illustration">
        <div class="container ">
            <div class="row">
                <div class="gap"></div>
                <h2 class="text-center">Why NaijaTravelShop?</h2>
                <div class="gap"></div>
                <div class="col-md-12">

                    <div class="row row-wrap" data-gutter="60">
                        <div class="col-md-3">
                            <div class="thumb">
                                <header class="thumb-header">
                                    <i class="fa fa-headphones box-icon-black round box-icon-big animate-icon-top-to-bottom"></i>
                                </header>
                                <div class="thumb-caption">
                                    <h5 class="thumb-title">
                                        <a class="text-darken" href="#">247 Support</a>
                                    </h5>
                                    <p class="thumb-desc">We provide end-to-end support to give you your desired travel experience. </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="thumb">
                                <header class="thumb-header">
                                    <i class="fa fa-plane box-icon-black round box-icon-big animate-icon-top-to-bottom"></i>
                                </header>
                                <div class="thumb-caption">
                                    <h5 class="thumb-title">
                                        <a class="text-darken" href="#">Best Travel Deals</a>
                                    </h5>
                                    <p class="thumb-desc">We can always give you the best travel deal you can ever find anywhere. You earn points for every flight or hotel you book with us. </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="thumb">
                                <header class="thumb-header">
                                    <i class="fa fa-thumbs-o-up box-icon-black round box-icon-big animate-icon-top-to-bottom"></i>
                                </header>
                                <div class="thumb-caption">
                                    <h5 class="thumb-title">
                                        <a class="text-darken" href="#">Valuable VISA</a>
                                    </h5>
                                    <p class="thumb-desc">We provide valuable visa information and assistance and make your visa application process seamless and highly likely to succeed.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="thumb">
                                <header class="thumb-header">
                                    <i class="fa fa-send box-icon-black round box-icon-big animate-icon-top-to-bottom"></i>
                                </header>
                                <div class="thumb-caption">
                                    <h5 class="thumb-title">
                                        <a class="text-darken" href="#">Best Destinations</a>
                                    </h5>
                                    <p class="thumb-desc">We are connected to the most amazing hotels in the world. We can completely manage your itinerary including all personal and business travel.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="gap gap-small"></div>
        </div>
        </div>


        <?php include('includes/footer.php'); ?>