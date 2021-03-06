package technic.dsl;


import org.apache.tinkerpop.gremlin.process.remote.RemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategies;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.DefaultGraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.GraphStep;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class TechnicTraversalSourceDsl extends GraphTraversalSource {
    public TechnicTraversalSourceDsl(final Graph graph, final TraversalStrategies traversalStrategies) {
        super(graph, traversalStrategies);
    }

    public TechnicTraversalSourceDsl(final Graph graph) {
        super(graph);
    }

    public TechnicTraversalSourceDsl(final RemoteConnection remoteConnection) {
        super(remoteConnection);
    }

    public GraphTraversal<Vertex, Vertex> gear(String gearId) {
        GraphTraversalSource clone = this.clone();

        clone.getBytecode().addStep("gear", gearId);
        GraphTraversal<Vertex, Vertex> traversal = new DefaultGraphTraversal<>(clone);
        traversal.asAdmin().addStep(new GraphStep<>(traversal.asAdmin(), Vertex.class, true));

        return traversal;
    }
}