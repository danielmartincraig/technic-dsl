package technic.dsl;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.GremlinDsl;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;

@GremlinDsl(traversalSource = "technic.dsl.TechnicTraversalSourceDsl")
public interface TechnicTraversalDsl<S, E> extends GraphTraversal.Admin<S, E> {
    
    public default GraphTraversal<S, Vertex> gear(String gearId) {
        return V(gearId).fold().coalesce(__.unfold(), __.addV("gear").property(T.id, gearId));
    }

    public default GraphTraversal<S, Edge> drives(final GraphTraversal<S, Vertex> traversal) {
        return coalesce(__.outE("drives").filter(__.inV().has(T.id, traversal.asAdmin().clone().id())),
                        __.addE("drives").to(traversal));
    }

}
