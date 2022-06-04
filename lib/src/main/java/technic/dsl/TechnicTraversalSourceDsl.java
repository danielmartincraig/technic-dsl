package technic.dsl;


import org.apache.tinkerpop.gremlin.process.remote.RemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategies;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;

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
}