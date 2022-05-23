package com.flightgearserver.demo.Http.Entiteis;

import javax.persistence.*;

@Entity
@Table(name = "flightsdata")
public class Flightsdatum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flightid")
    private Long flightid;

    @Column(name = "aileron")
    private Double aileron;

    @Column(name = "elevator")
    private Double elevator;

    @Column(name = "rudder")
    private Double rudder;

    @Column(name = "flaps")
    private Double flaps;

    @Column(name = "throttle")
    private Double throttle;

    @Column(name = "rpm")
    private Double rpm;

    @Column(name = "speedbrake")
    private Double speedbrake;

    @Column(name = "\"indicated-speed-kt\"")
    private Double indicatedSpeedKt;

    @Column(name = "\"indicated-altitude-ft\"")
    private Double indicatedAltitudeFt;

    @Column(name = "\"pressure-alt-ft\"")
    private Double pressureAltFt;

    @Column(name = "\"indicated-pitch-deg\"")
    private Double indicatedPitchDeg;

    @Column(name = "\"indicated-roll-deg\"")
    private Double indicatedRollDeg;

    @Column(name = "\"internal-pitch-deg\"")
    private Double internalPitchDeg;

    @Column(name = "\"internal-roll-deg\"")
    private Double internalRollDeg;

    @Column(name = "\"encoder-indicated-altitude-ft\"")
    private Double encoderIndicatedAltitudeFt;

    @Column(name = "\"encoder-pressure-alt-ft\"")
    private Double encoderPressureAltFt;

    @Column(name = "\"gps-indicated-altitude-ft\"")
    private Double gpsIndicatedAltitudeFt;

    @Column(name = "\"indicated-ground-speed-kt\"")
    private Double indicatedGroundSpeedKt;

    @Column(name = "\"indicated-vertical-speed\"")
    private Double indicatedVerticalSpeed;

    @Column(name = "\"indicated-heading-deg\"")
    private Double indicatedHeadingDeg;

    @Column(name = "\"compass-indicated-heading-deg\"")
    private Double compassIndicatedHeadingDeg;

    @Column(name = "\"indicated-slip-skid\"")
    private Double indicatedSlipSkid;

    @Column(name = "\"indicated-turn-rate\"")
    private Double indicatedTurnRate;

    @Column(name = "\"indicated-speed-fpm\"")
    private Double indicatedSpeedFpm;

    @Column(name = "\"timestamp\"")
    private Long timestamp;

    public Flightsdatum(double[] arr, long flightid,long timeStamp) {
        this.flightid=flightid;
        this.timestamp=timeStamp;
         aileron=arr[0];
         elevator=arr[1];
         rudder=arr[2];
         flaps=arr[3];
         throttle=arr[4];
         rpm=arr[5];
         speedbrake=arr[6];
         indicatedSpeedKt=arr[7];
         indicatedAltitudeFt=arr[8];
         pressureAltFt=arr[9];
         indicatedPitchDeg=arr[10];
         indicatedRollDeg=arr[11];
         internalPitchDeg=arr[12];
         internalRollDeg=arr[13];
         encoderIndicatedAltitudeFt=arr[14];
         encoderPressureAltFt=arr[15];
         gpsIndicatedAltitudeFt=arr[16];
         indicatedGroundSpeedKt=arr[17];
         indicatedVerticalSpeed=arr[18];
         indicatedHeadingDeg=arr[19];
         compassIndicatedHeadingDeg=arr[20];
         indicatedSlipSkid=arr[21];
         indicatedTurnRate=arr[22];
         indicatedSpeedFpm=arr[23];
    }

    public Flightsdatum() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getFlightid() {
        return flightid;
    }

    public void setFlightid(long flightid) {
        this.flightid = flightid;
    }

    public Double getAileron() {
        return aileron;
    }

    public void setAileron(Double aileron) {
        this.aileron = aileron;
    }

    public Double getElevator() {
        return elevator;
    }

    public void setElevator(Double elevator) {
        this.elevator = elevator;
    }

    public Double getRudder() {
        return rudder;
    }

    public void setRudder(Double rudder) {
        this.rudder = rudder;
    }

    public Double getFlaps() {
        return flaps;
    }

    public void setFlaps(Double flaps) {
        this.flaps = flaps;
    }

    public Double getThrottle() {
        return throttle;
    }

    public void setThrottle(Double throttle) {
        this.throttle = throttle;
    }

    public Double getRpm() {
        return rpm;
    }

    public void setRpm(Double rpm) {
        this.rpm = rpm;
    }

    public Double getSpeedbrake() {
        return speedbrake;
    }

    public void setSpeedbrake(Double speedbrake) {
        this.speedbrake = speedbrake;
    }

    public Double getIndicatedSpeedKt() {
        return indicatedSpeedKt;
    }

    public void setIndicatedSpeedKt(Double indicatedSpeedKt) {
        this.indicatedSpeedKt = indicatedSpeedKt;
    }

    public Double getIndicatedAltitudeFt() {
        return indicatedAltitudeFt;
    }

    public void setIndicatedAltitudeFt(Double indicatedAltitudeFt) {
        this.indicatedAltitudeFt = indicatedAltitudeFt;
    }

    public Double getPressureAltFt() {
        return pressureAltFt;
    }

    public void setPressureAltFt(Double pressureAltFt) {
        this.pressureAltFt = pressureAltFt;
    }

    public Double getIndicatedPitchDeg() {
        return indicatedPitchDeg;
    }

    public void setIndicatedPitchDeg(Double indicatedPitchDeg) {
        this.indicatedPitchDeg = indicatedPitchDeg;
    }

    public Double getIndicatedRollDeg() {
        return indicatedRollDeg;
    }

    public void setIndicatedRollDeg(Double indicatedRollDeg) {
        this.indicatedRollDeg = indicatedRollDeg;
    }

    public Double getInternalPitchDeg() {
        return internalPitchDeg;
    }

    public void setInternalPitchDeg(Double internalPitchDeg) {
        this.internalPitchDeg = internalPitchDeg;
    }

    public Double getInternalRollDeg() {
        return internalRollDeg;
    }

    public void setInternalRollDeg(Double internalRollDeg) {
        this.internalRollDeg = internalRollDeg;
    }

    public Double getEncoderIndicatedAltitudeFt() {
        return encoderIndicatedAltitudeFt;
    }

    public void setEncoderIndicatedAltitudeFt(Double encoderIndicatedAltitudeFt) {
        this.encoderIndicatedAltitudeFt = encoderIndicatedAltitudeFt;
    }

    public Double getEncoderPressureAltFt() {
        return encoderPressureAltFt;
    }

    public void setEncoderPressureAltFt(Double encoderPressureAltFt) {
        this.encoderPressureAltFt = encoderPressureAltFt;
    }

    public Double getGpsIndicatedAltitudeFt() {
        return gpsIndicatedAltitudeFt;
    }

    public void setGpsIndicatedAltitudeFt(Double gpsIndicatedAltitudeFt) {
        this.gpsIndicatedAltitudeFt = gpsIndicatedAltitudeFt;
    }

    public Double getIndicatedGroundSpeedKt() {
        return indicatedGroundSpeedKt;
    }

    public void setIndicatedGroundSpeedKt(Double indicatedGroundSpeedKt) {
        this.indicatedGroundSpeedKt = indicatedGroundSpeedKt;
    }

    public Double getIndicatedVerticalSpeed() {
        return indicatedVerticalSpeed;
    }

    public void setIndicatedVerticalSpeed(Double indicatedVerticalSpeed) {
        this.indicatedVerticalSpeed = indicatedVerticalSpeed;
    }

    public Double getIndicatedHeadingDeg() {
        return indicatedHeadingDeg;
    }

    public void setIndicatedHeadingDeg(Double indicatedHeadingDeg) {
        this.indicatedHeadingDeg = indicatedHeadingDeg;
    }

    public Double getCompassIndicatedHeadingDeg() {
        return compassIndicatedHeadingDeg;
    }

    public void setCompassIndicatedHeadingDeg(Double compassIndicatedHeadingDeg) {
        this.compassIndicatedHeadingDeg = compassIndicatedHeadingDeg;
    }

    public Double getIndicatedSlipSkid() {
        return indicatedSlipSkid;
    }

    public void setIndicatedSlipSkid(Double indicatedSlipSkid) {
        this.indicatedSlipSkid = indicatedSlipSkid;
    }

    public Double getIndicatedTurnRate() {
        return indicatedTurnRate;
    }

    public void setIndicatedTurnRate(Double indicatedTurnRate) {
        this.indicatedTurnRate = indicatedTurnRate;
    }

    public Double getIndicatedSpeedFpm() {
        return indicatedSpeedFpm;
    }

    public void setIndicatedSpeedFpm(Double indicatedSpeedFpm) {
        this.indicatedSpeedFpm = indicatedSpeedFpm;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}