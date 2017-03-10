import {Component, ViewChild, ElementRef} from '@angular/core';
import {NavController, NavParams} from 'ionic-angular';

declare var google: any;

/*
 Generated class for the Locations page.

 See http://ionicframework.com/docs/v2/components/#navigation for more info on
 Ionic pages and navigation.
 */
@Component({
  selector: 'page-locations',
  templateUrl: 'locations.html'
})
export class LocationsPage {

  public map: any;

  @ViewChild("map") mapElement: ElementRef;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LocationsPage');

    this.loadMap();
  }

  loadMap() {
    console.log("loadMap executing");

    let latitude = 40.600920
    let longitude = -91.702881;

    let latLng = new google.maps.LatLng(latitude, longitude);

    let mapOptions = {
      center: latLng,
      zoom: 5,
      maxZoom: 5,
      minZoom: 5,
      panControl: false,
      draggable: false,
      mapTypeId: google.maps.MapTypeId.ROADMAP,
      mapTypeControl: false,
      zoomControl: false,
      streetViewControl: false
    };
    this.map = new google.maps.Map(this.mapElement.nativeElement, mapOptions);
    this.setMarkers();
    this.refreshTheMap();
  }

  refreshTheMap() { // TODO: Move this to a map handler class to reuse in our base
    // refresh map
    setTimeout(() => {
      google.maps.event.trigger(this.map, 'resize');
    }, 300);
  }

  setMarkers() {
    console.log("Setting markers");
    let lincoln = {lat: 40.832255, lng: -96.674194};
    let kansasCity = {lat: 39.046653, lng: -94.586792};
    let stLouis = {lat: 38.627331, lng: -90.214233};
    let chicago = {lat: 41.879531, lng: -87.621460};
    let lincolnMarker = new google.maps.Marker({
      position: lincoln,
      map: this.map,
      title: 'Keyhole Lincoln/Omaha'
    });
    let kansasCityMarker = new google.maps.Marker({
      position: kansasCity,
      map: this.map,
      title: 'Keyhole HQ'
    });
    let stLouisMarker = new google.maps.Marker({
      position: stLouis,
      map: this.map,
      title: 'Keyhole St Louis'
    });
    let chicagoMarker = new google.maps.Marker({
      position: chicago,
      map: this.map,
      title: 'Keyhole Chicago'
    });
    lincolnMarker.setMap(this.map);
    kansasCityMarker.setMap(this.map);
    stLouisMarker.setMap(this.map);
    chicagoMarker.setMap(this.map);
    console.log("Markers set")
  }
}
