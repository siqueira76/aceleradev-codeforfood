package com.codeforfood.mapfood.domain;

public class Route {

    private Position initialPosition;
    private Position targetPosition;


    public Route(Position initialPosition, Position targetPosition) {
        this.initialPosition = initialPosition;
        this.targetPosition = targetPosition;
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(Position initialPosition) {
        this.initialPosition = initialPosition;
    }

    public Position getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Position targetPosition) {
        this.targetPosition = targetPosition;
    }
}
