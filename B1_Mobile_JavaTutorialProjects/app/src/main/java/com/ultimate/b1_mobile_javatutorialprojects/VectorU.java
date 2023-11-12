package com.ultimate.b1_mobile_javatutorialprojects;

import androidx.annotation.NonNull;

public class VectorU {
    private float x, y, z;

    public VectorU() {
        x = y = z = 0;
    }

    public VectorU(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public VectorU CongVector(VectorU v) {
        return new VectorU(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public VectorU CongVector(VectorU v1, VectorU v2){
        return new VectorU(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public float TichVoHuong(VectorU v){
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public float Module(){
        return (float) Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    @NonNull
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
