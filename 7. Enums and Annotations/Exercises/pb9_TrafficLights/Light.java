package pb9_TrafficLights;

public enum Light {
    RED,
    GREEN,
    YELLOW;

    public Light update(Light light){
        if(light.ordinal()==0){
            light=Light.GREEN;
        }else if(light.ordinal()==1){
            light=Light.YELLOW;
        }else {
            light=Light.RED;
        }
        return light;
    }
}

