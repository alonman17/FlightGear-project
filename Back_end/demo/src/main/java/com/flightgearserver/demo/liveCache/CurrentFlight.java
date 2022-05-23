package com.flightgearserver.demo.liveCache;
public class CurrentFlight {

    private Double aileron;
    private Double elevator;
    private Double rudder;
    private Double flaps;
    private Double throttle;
    private Double rpm;
    private Double speedbrake;
    private Double indicatedSpeedKt;
    private Double indicatedAltitudeFt;
    private Double pressureAltFt;
    private Double indicatedPitchDeg;
    private Double indicatedRollDeg;
    private Double internalPitchDeg;
    private Double internalRollDeg;
    private Double encoderIndicatedAltitudeFt;
    private Double encoderPressureAltFt;
    private Double gpsIndicatedAltitudeFt;
    private Double indicatedGroundSpeedKt;
    private Double indicatedVerticalSpeed;
    private Double indicatedHeadingDeg;
    private Double compassIndicatedHeadingDeg;
    private Double indicatedSlipSkid;
    private Double indicatedTurnRate;
    private Double indicatedSpeedFpm;
    private Long timestamp;

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

    public void setALL(double[] arr){
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

    @Override
    public String toString() {
        return "CurrentFlight{" +
                "aileron=" + aileron +
                ", elevator=" + elevator +
                ", rudder=" + rudder +
                ", flaps=" + flaps +
                ", throttle=" + throttle +
                ", rpm=" + rpm +
                ", speedbrake=" + speedbrake +
                ", indicatedSpeedKt=" + indicatedSpeedKt +
                ", indicatedAltitudeFt=" + indicatedAltitudeFt +
                ", pressureAltFt=" + pressureAltFt +
                ", indicatedPitchDeg=" + indicatedPitchDeg +
                ", indicatedRollDeg=" + indicatedRollDeg +
                ", internalPitchDeg=" + internalPitchDeg +
                ", internalRollDeg=" + internalRollDeg +
                ", encoderIndicatedAltitudeFt=" + encoderIndicatedAltitudeFt +
                ", encoderPressureAltFt=" + encoderPressureAltFt +
                ", gpsIndicatedAltitudeFt=" + gpsIndicatedAltitudeFt +
                ", indicatedGroundSpeedKt=" + indicatedGroundSpeedKt +
                ", indicatedVerticalSpeed=" + indicatedVerticalSpeed +
                ", indicatedHeadingDeg=" + indicatedHeadingDeg +
                ", compassIndicatedHeadingDeg=" + compassIndicatedHeadingDeg +
                ", indicatedSlipSkid=" + indicatedSlipSkid +
                ", indicatedTurnRate=" + indicatedTurnRate +
                ", indicatedSpeedFpm=" + indicatedSpeedFpm +
                ", timestamp=" + timestamp +
                '}';
    }
}
