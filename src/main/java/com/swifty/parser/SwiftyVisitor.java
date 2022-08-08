// Generated from /Users/alex/Developer/Swifty/src/main/java/antlr/Swifty.g4 by ANTLR 4.10.1
package com.swifty.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SwiftyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SwiftyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(SwiftyParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(SwiftyParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(SwiftyParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(SwiftyParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(SwiftyParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(SwiftyParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(SwiftyParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#parametersList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersList(SwiftyParser.ParametersListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(SwiftyParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(SwiftyParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#parameterWithDefaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterWithDefaultValue(SwiftyParser.ParameterWithDefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SwiftyParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(SwiftyParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(SwiftyParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SwiftyParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SwiftyParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(SwiftyParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SwiftyParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(SwiftyParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnWithValue}
	 * labeled alternative in {@link SwiftyParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnWithValue(SwiftyParser.ReturnWithValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link SwiftyParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnVoid(SwiftyParser.ReturnVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SwiftyParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(SwiftyParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#forConditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForConditions(SwiftyParser.ForConditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(SwiftyParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnnamedArgumentsList}
	 * labeled alternative in {@link SwiftyParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnnamedArgumentsList(SwiftyParser.UnnamedArgumentsListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NamedArgumentsList}
	 * labeled alternative in {@link SwiftyParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedArgumentsList(SwiftyParser.NamedArgumentsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(SwiftyParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#namedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedArgument(SwiftyParser.NamedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(SwiftyParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Substract}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstract(SwiftyParser.SubstractContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(SwiftyParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(SwiftyParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarReference}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarReference(SwiftyParser.VarReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(SwiftyParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(SwiftyParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Supercall}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupercall(SwiftyParser.SupercallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SwiftyParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstructorCall}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorCall(SwiftyParser.ConstructorCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#variableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(SwiftyParser.VariableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SwiftyParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SwiftyParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(SwiftyParser.QualifiedNameContext ctx);
}