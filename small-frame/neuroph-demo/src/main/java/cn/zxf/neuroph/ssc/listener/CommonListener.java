package cn.zxf.neuroph.ssc.listener;

import org.neuroph.core.Connection;
import org.neuroph.core.Neuron;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.nnet.learning.BackPropagation;

public class CommonListener implements LearningEventListener {

    public static CommonListener INSTANCE = new CommonListener();

    @Override
    public void handleLearningEvent( LearningEvent event ) {
        BackPropagation bp = (BackPropagation) event.getSource();
        System.out.println( "迭代次数：" + bp.getCurrentIteration() + "，总误差：" + bp.getTotalNetworkError() );
        Neuron neuron = (Neuron) bp.getNeuralNetwork().getOutputNeurons()[0];
        for ( Connection conn : neuron.getInputConnections() ) {
            System.out.print( conn.getWeight().value + "\t" );
        }
        System.out.println( "\n--------------------" );
    }

}
